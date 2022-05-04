// You are allowed to add imports here


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class implements a publisher of news. News are strings
 * and have a topic. The topic is a number from 0 to 10.
 * (for example: 0=Sport, 1=Music,...).
 * Subscribers are observers of news. They can subscribe to one or more
 * topics and will receive the news that are published on this topic.
 * Example:
 *      NewsPublisher publisher = new NewsPublisher();
 *      NewsPublisher.Subscriber subscriber = .....
 *      publisher.subscribe(subscriber, 0);  // subscribe to topic 0
 *      publisher.subscribe(subscriber, 1);  // subscribe to topic 1
 *      publisher.publishNews(0, "The national team has won"); // news for topic 0
 *      publisher.publishNews(1, "Famous pianist in town");    // news for topic 1
 */

public class NewsPublisher {
    // You are allowed to add methods or class members here
    HashMap<Integer, List<Subscriber>> dic = new HashMap<>();
    List<Subscriber> tous = new ArrayList<>();


    /**
     * A subscriber subscribes to one or more topics. Everytime
     * a news on one of those topics is published, the subscriber
     * is notified and receives a copy of the news.
     */
    public interface Subscriber {
        void newsArrived(String news);
    }

    /**
     * Subscribes the subscriber to a specific topic.
     * If the subscriber is already subscribed to the topic, nothing happens.
     * A subscriber can subscribe to multiple topics.
     *
     * @param subscriber the subscriber
     * @param topic the topic to subscribe to
     *
     * You can assume that "topic" is a number in 0..10 (included)
     */
    public void subscribe(Subscriber subscriber, int topic) {
        if (!dic.containsKey(topic)) dic.put(topic, new ArrayList<>());
        if (!tous.contains(subscriber)) tous.add(subscriber);
        if (!dic.get(topic).contains(subscriber)) dic.get(topic).add(subscriber);
    }

    /**
     * Unsubscribes the subscriber to the topic
     * If the subscriber was not subscribed to the topic, nothing happens.
     *
     * @param subscriber the subscriber
     * @param topic the topic to unsubscribe to
     *
     * You can assume that "topic" is a number in 0..10 (included)
     */
    public void unsubscribe(Subscriber subscriber, int topic) {
        boolean stillHere = false;
        if (dic.containsKey(topic)){
            if (dic.get(topic).contains(subscriber)){
                dic.get(topic).remove(subscriber);
                for (int i = 0; i < 11; i++) {
                    if (dic.containsKey(i)){
                        if (dic.get(i).contains(subscriber)){
                            stillHere = true;
                        }
                    }
                }
                if (!stillHere){
                    tous.remove(subscriber);
                }
            }
        }
    }

    /**
     * Publishes news on a specific topic. The subscribers of that
     * topic will be notified.
     *
     * If the topic is -1, ALL subscribers will be notified. But be
     * careful: no subscriber should receive the news twice!
     *
     * @param topic the topic of the news (-1 if sent to everybody)
     * @param news the news
     *
     * You can assume that "topic" is a number in 0..10 (included) or -1.
     */
    public void publishNews(int topic, String news) {
        if (topic == -1){
            for (Subscriber s : tous){
                s.newsArrived(news);
            }
        } else if (dic.containsKey(topic)){
            for (Subscriber s : dic.get(topic)){
                s.newsArrived(news);
            }
        }
    }
}
