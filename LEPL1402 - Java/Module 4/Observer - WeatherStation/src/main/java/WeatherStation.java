public class WeatherStation extends Observable{

    @Override
    public Observer[] getSubscribers() {
        Observer[] answer = new Observer[subscribers.size()];
        for (int i = 0; i < subscribers.size(); i++) {
            answer[i] = subscribers.get(i);
        }
        return answer;
    }

    @Override
    public void broadcast(Pair<String, Integer> pair) {
        for (int i = 0; i < subscribers.size(); i++) {
            if (subscribers.get(i).getZone() == pair.getZone()){
                subscribers.get(i).update(pair);
            }
        }
    }

    @Override
    public void addObserver(Observer sub) {
        if (!subscribers.contains(sub)){
            subscribers.add(sub);
        }
    }

    @Override
    public boolean removeObserver(Observer sub) {
        for (int i = 0; i < subscribers.size(); i++) {
            if (subscribers.get(i) == sub){
                subscribers.remove(sub);
                return true;
            }
        }
        return false;
    }


    @Override
    public void setAlert(String alert, int zone) {
        for (int i = 0; i < subscribers.size(); i++) {
            if (subscribers.get(i).getZone() == zone){
                subscribers.get(i).update(alert);
            }
        }
    }
}
