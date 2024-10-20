import java.util.*;

class Twitter {

    private static int timeStamp = 0;  // Global timestamp
    private Map<Integer, Set<Integer>> followers; // To store followers of each user
    private Map<Integer, List<Tweet>> tweets; // To store tweets of each user

    // Tweet class to store tweetId and the timestamp
    private class Tweet {
        int tweetId;
        int time;

        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
    }

    // User posts a new tweet
    public void postTweet(int userId, int tweetId) {
        // Create tweet list for the user if it doesn't exist
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        // Add the tweet to the user's tweet list with a timestamp
        tweets.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    // Get the 10 most recent tweet IDs in the user's news feed
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> feed = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add the user's tweets to the feed
        if (tweets.containsKey(userId)) {
            feed.addAll(tweets.get(userId));
        }

        // Add tweets from all users that the user follows
        if (followers.containsKey(userId)) {
            for (int followeeId : followers.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    feed.addAll(tweets.get(followeeId));
                }
            }
        }

        // Collect the 10 most recent tweets
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!feed.isEmpty() && count < 10) {
            result.add(feed.poll().tweetId);
            count++;
        }

        return result;
    }

    // User follows another user
    public void follow(int followerId, int followeeId) {
        // A user cannot follow themselves
        if (followerId == followeeId) return;

        // Create follower list for the user if it doesn't exist
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>());
        }

        // Add the followee to the follower's list
        followers.get(followerId).add(followeeId);
    }

    // User unfollows another user
    public void unfollow(int followerId, int followeeId) {
        // If the user is following the followee, remove them
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
