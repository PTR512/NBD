package mappers;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

import java.lang.reflect.Type;
import java.util.List;

public class UniqueIdCodecProvider implements CodecProvider {
    public UniqueIdCodecProvider() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry codecRegistry) {
        if (clazz == MongoUniqueId.class){
            return (Codec<T>) new MongoUniqueIdCodec(codecRegistry);
        }
        return null;
    }
}
