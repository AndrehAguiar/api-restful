package one.digitalinnovation.apirestful.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.PackageVersion;
import one.digitalinnovation.apirestful.enums.Breed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class Jackson {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // PRORPIEDADES NÃO MAPEADAS NÃO QUEBRAM
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // FALHA SE ALGUMA PRORPIEDADE ESTIVER VAZIA
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // SERVE PARA COMPATIBILIDADE DE ARRAYS
        // QUANDO TEM UM ARRAY COM UM ITEM
        // CASO NÃO TENHA ESSA CONFIG ELE SE PERDE
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        // SERIALIZE DATAS
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(breedModuleMapper());
        return objectMapper;
    }

    public SimpleModule breedModuleMapper() {
        SimpleModule dateModule = new SimpleModule("JSONBreedModule", PackageVersion.VERSION);
        dateModule.addSerializer(Breed.class, new BreedSerialize());
        dateModule.addDeserializer(Breed.class, new BreedDeserialize());
        return dateModule;
    }

    static class BreedSerialize extends StdSerializer<Breed> {

        protected BreedSerialize() {
            super(Breed.class);
        }

        @Override
        public void serialize(Breed breed, JsonGenerator json, SerializerProvider provider) throws IOException {
            json.writeString(breed.name());
        }
    }

    static class BreedDeserialize extends StdDeserializer<Breed> {
        protected BreedDeserialize() {
            super(Breed.class);
        }

        @Override
        public Breed deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return Breed.of(p.getText());
        }
    }

}
