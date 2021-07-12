package fo.us.folkv3.api.client;

import javax.xml.ws.Holder;

@FunctionalInterface
public interface CallConsumer<T> {

    void accept(Holder<String> status, Holder<String> message, Holder<T> result);

}
