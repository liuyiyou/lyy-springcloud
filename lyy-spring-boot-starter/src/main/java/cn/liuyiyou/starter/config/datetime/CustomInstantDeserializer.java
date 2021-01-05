package cn.liuyiyou.starter.config.datetime;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.datatype.jsr310.deser.JSR310DateTimeDeserializerBase;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author: liuyiyou.cn
 * @date: 2020/9/22
 * @version: V1.0
 */
public class CustomInstantDeserializer extends JSR310DateTimeDeserializerBase<Instant> {

    @Override
    protected JSR310DateTimeDeserializerBase<Instant> withShape(final Shape shape) {
        return this;
    }

    public static final CustomInstantDeserializer INSTANCE = new CustomInstantDeserializer();

    private static final DateTimeFormatter ISOFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

    public CustomInstantDeserializer() {
        this(Instant.class, ISOFormatter);
    }

    public CustomInstantDeserializer(Class<Instant> supportedType,
        DateTimeFormatter f) {
        super(supportedType, f);
    }

    public CustomInstantDeserializer(
        final JSR310DateTimeDeserializerBase<Instant> base, final DateTimeFormatter f) {
        super(base, f);
    }

    public CustomInstantDeserializer(
        final JSR310DateTimeDeserializerBase<Instant> base, final Boolean leniency) {
        super(base, leniency);
    }

    @Override
    protected JSR310DateTimeDeserializerBase<Instant> withDateFormat(DateTimeFormatter dtf) {
        return new CustomInstantDeserializer(this, ISOFormatter);
    }

    @Override
    protected JSR310DateTimeDeserializerBase<Instant> withLeniency(final Boolean leniency) {
        return this;
    }

    /**
     * @see  com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer#deserialize(JsonParser, DeserializationContext)
     * @param parser
     * @param ctxt
     * @return
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public Instant deserialize(final JsonParser parser, final DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
        switch (parser.getCurrentToken()) {
            case VALUE_STRING:
                String string = parser.getText().trim();
                if (string.length() == 0) {
                    return null;
                }
                if (string.contains("T")) {
                    return Instant.parse(string);
                }
                return LocalDateTime.parse(string, ISOFormatter).toInstant(ZoneOffset.ofHours(8));

        }
        throw ctxt
            .wrongTokenException(parser, JsonToken.START_ARRAY, "Expected array or string.");

    }
}