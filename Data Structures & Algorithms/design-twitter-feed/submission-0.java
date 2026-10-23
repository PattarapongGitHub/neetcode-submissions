class Twitter {
    // ตัวนับกลาง
    int time;
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> follows;

    public Twitter() {
        time = 0;
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            List<int[]> userTweets = new ArrayList<>();
            tweets.put(userId, userTweets);
        }
        int[] tweet = new int[2];
        tweet[0] = time;
        tweet[1] = tweetId;
        tweets.get(userId).add(tweet);
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<Integer> users = new HashSet<>();
        users.add(userId);

        if (follows.containsKey(userId)) {
            for (int follow : follows.get(userId)) {
                users.add(follow);
            }
        }

        for (int user : users) {
            if (tweets.containsKey(user)) {
                List<int[]> userTweets = tweets.get(user);
                int lastIndex = userTweets.size() - 1;
                int[] lastTweet = userTweets.get(lastIndex);
                int[] entry = new int[4];
                entry[0] = lastTweet[0];
                entry[1] = lastTweet[1];
                entry[2] = user;
                entry[3] = lastIndex;
                p.add(entry);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!p.isEmpty() && (result.size() < 10)) {
            int[] top = p.poll();
            result.add(top[1]);
            if (top[3] > 0) {
                int[] entry = new int[4];
                List<int[]> userTweets = tweets.get(top[2]);
                int[] prevTweet = userTweets.get(top[3] - 1);
                entry[0] = prevTweet[0];
                entry[1] = prevTweet[1];
                entry[2] = top[2];
                entry[3] = top[3] - 1;
                p.offer(entry);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId)) {
            Set<Integer> userfollows = new HashSet<>();
            follows.put(followerId, userfollows);
        }
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
