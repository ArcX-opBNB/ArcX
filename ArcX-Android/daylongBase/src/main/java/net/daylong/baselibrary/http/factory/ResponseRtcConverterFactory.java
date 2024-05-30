package net.daylong.baselibrary.http.factory;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import net.daylong.baselibrary.http.GsonRequestConverter;
import net.daylong.baselibrary.http.GsonResponseBodyConverter;
import net.daylong.baselibrary.http.GsonResponseRtcBodyConverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class ResponseRtcConverterFactory extends Converter.Factory {
    public static ResponseRtcConverterFactory create() {
        return create(new Gson());
    }

    public static ResponseRtcConverterFactory create(Gson gson) {
        return new ResponseRtcConverterFactory(gson);
    }

    private final Gson gson;

    private ResponseRtcConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        
        return new GsonResponseRtcBodyConverter<>(gson, type);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        

        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));

        return new GsonRequestConverter<>(gson, adapter);
    }
}
