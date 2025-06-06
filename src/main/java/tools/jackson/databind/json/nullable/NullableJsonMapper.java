package tools.jackson.databind.json.nullable;

import org.jspecify.annotations.Nullable;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.core.JsonParser;
import tools.jackson.core.TreeNode;
import tools.jackson.core.Version;
import tools.jackson.core.json.JsonFactory;
import tools.jackson.core.json.JsonReadFeature;
import tools.jackson.core.json.JsonWriteFeature;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.DeserializationConfig;
import tools.jackson.databind.InjectableValues;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.MappingIterator;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.ObjectReader;
import tools.jackson.databind.SerializationConfig;
import tools.jackson.databind.cfg.MapperBuilder;
import tools.jackson.databind.cfg.MapperBuilderState;
import tools.jackson.databind.node.JsonNodeFactory;
import tools.jackson.databind.nullable.NullableObjectReader;
import tools.jackson.databind.type.TypeFactory;
import tools.jackson.databind.util.TokenBuffer;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Path;

public class NullableJsonMapper extends ObjectMapper {
    private static final long serialVersionUID = 1L;

    public static class Builder
            extends MapperBuilder<NullableJsonMapper, NullableJsonMapper.Builder> {

        public Builder(JsonFactory f) {
            super(f);
        }

        protected Builder(MapperBuilderState state) {
            super(state);
        }

        @Override
        public NullableJsonMapper build() {
            return new NullableJsonMapper(this);
        }

        @Override
        protected MapperBuilderState _saveState() {
            return new NullableJsonMapper.Builder.StateImpl(this);
        }

        protected static class StateImpl extends MapperBuilderState
                implements java.io.Serializable // important!
        {
            private static final long serialVersionUID = 3L;

            public StateImpl(NullableJsonMapper.Builder src) {
                super(src);
            }

            // We also need actual instance of state as base class cannot implement logic
            // for reinstating mapper (via mapper builder) from state.
            @Override
            protected Object readResolve() {
                return new NullableJsonMapper.Builder(this).build();
            }
        }

        /*
        /******************************************************************
        /* Format features
        /******************************************************************
         */

        public NullableJsonMapper.Builder enable(JsonReadFeature... features) {
            for (JsonReadFeature f : features) {
                _formatReadFeatures |= f.getMask();
            }
            return this;
        }

        public NullableJsonMapper.Builder disable(JsonReadFeature... features) {
            for (JsonReadFeature f : features) {
                _formatReadFeatures &= ~f.getMask();
            }
            return this;
        }

        public NullableJsonMapper.Builder configure(JsonReadFeature feature, boolean state)
        {
            if (state) {
                _formatReadFeatures |= feature.getMask();
            } else {
                _formatReadFeatures &= ~feature.getMask();
            }
            return this;
        }

        public NullableJsonMapper.Builder enable(JsonWriteFeature... features) {
            for (JsonWriteFeature f : features) {
                _formatWriteFeatures |= f.getMask();
            }
            return this;
        }

        public NullableJsonMapper.Builder disable(JsonWriteFeature... features) {
            for (JsonWriteFeature f : features) {
                _formatWriteFeatures &= ~f.getMask();
            }
            return this;
        }

        public NullableJsonMapper.Builder configure(JsonWriteFeature feature, boolean state)
        {
            if (state) {
                _formatWriteFeatures |= feature.getMask();
            } else {
                _formatWriteFeatures &= ~feature.getMask();
            }
            return this;
        }
    }

    protected NullableJsonMapper(Builder builder) {
        super(builder);
    }

    /*
    /**********************************************************************
    /* Life-cycle, builders
    /**********************************************************************
     */

    public static NullableJsonMapper.Builder builder() {
        return new NullableJsonMapper.Builder(new JsonFactory());
    }

    public static NullableJsonMapper.Builder builder(JsonFactory streamFactory) {
        return new NullableJsonMapper.Builder(streamFactory);
    }

    /**
     * Modifies the settings of this builder to more closely match the default configs used
     * in Jackson 2.x versions.
     * <p>
     *     This method is still a work in progress and may not yet fully replicate the
     *     default settings of Jackson 2.x.
     * </p>
     */
    public static NullableJsonMapper.Builder builderWithJackson2Defaults() {
        return builder(JsonFactory.builderWithJackson2Defaults().build())
                .configureForJackson2();
    }

    /*
    /**********************************************************************
    /* Standard method overrides
    /**********************************************************************
     */

    @Override
    public Version version() {
        return super.version();
    }

    @Override
    public JsonFactory tokenStreamFactory() {
        return (JsonFactory) _streamFactory;
    }

    /*
    /**********************************************************
    /* Format-specific
    /**********************************************************
     */

    public boolean isEnabled(JsonReadFeature f) {
        return deserializationConfig().hasFormatFeature(f);
    }

    public boolean isEnabled(JsonWriteFeature f) {
        return serializationConfig().hasFormatFeature(f);
    }

    /*
    /**********************************************************************
    /* Configuration: main config object access
    /**********************************************************************
     */

    @Override
    public SerializationConfig serializationConfig() {
        return super.serializationConfig();
    }

    @Override
    public DeserializationConfig deserializationConfig() {
        return super.deserializationConfig();
    }

    @Override
    public JsonNodeFactory getNodeFactory() {
        return super.getNodeFactory();
    }

    @Override
    public InjectableValues getInjectableValues() {
        return super.getInjectableValues();
    }

    /*
    /**********************************************************************
    /* Configuration, access to type factory, type resolution
    /**********************************************************************
     */

    @Override
    public TypeFactory getTypeFactory() {
        return super.getTypeFactory();
    }

    @Override
    public JavaType constructType(Type type) {
        return super.constructType(type);
    }

    @Override
    public JavaType constructType(TypeReference<?> typeReference) {
        return super.constructType(typeReference);
    }




    /*
    /**********************************************************************
    /* Read Tree methods
    /**********************************************************************
     */

    @Override
    public JsonNode readTree(byte[] content) throws JacksonException {
        return super.readTree(content);
    }

    @Override
    public JsonNode readTree(byte[] content, int offset, int len) throws JacksonException {
        return super.readTree(content, offset, len);
    }

    @Override
    public JsonNode readTree(String content) throws JacksonException {
        return super.readTree(content);
    }

    @Override
    public JsonNode readTree(File file) throws JacksonException {
        return super.readTree(file);
    }

    @Override
    public JsonNode readTree(InputStream in) throws JacksonException {
        return super.readTree(in);
    }

    @Override
    public JsonNode readTree(JsonParser p) throws JacksonException {
        return super.readTree(p);
    }

    @Override
    public JsonNode readTree(Path path) throws JacksonException {
        return super.readTree(path);
    }

    @Override
    public JsonNode readTree(Reader r) throws JacksonException {
        return super.readTree(r);
    }

    @Override
    public JsonNode readTree(TokenBuffer src) throws JacksonException {
        return super.readTree(src);
    }

    @Override
    public JsonNode readTree(URL src) throws JacksonException {
        return super.readTree(src);
    }

    /*
    /**********************************************************************
    /* Read Value methods
    /**********************************************************************
     */

    @Override
    public <T> T readValue(byte[] content, int offset, int len, Class<T> valueType) throws JacksonException {
        return super.readValue(content, offset, len, valueType);
    }

    @Override
    public <T> T readValue(byte[] content, int offset, int len, JavaType valueType) throws JacksonException {
        return super.readValue(content, offset, len, valueType);
    }

    @Override
    public <T> T readValue(byte[] content, int offset, int len, TypeReference<T> valueTypeRef) throws JacksonException {
        return super.readValue(content, offset, len, valueTypeRef);
    }

    @Override
    public <T> T readValue(byte[] content, Class<T> valueType) throws JacksonException {
        return super.readValue(content, valueType);
    }

    @Override
    public <T> T readValue(byte[] content, JavaType valueType) throws JacksonException {
        return super.readValue(content, valueType);
    }

    @Override
    public <T> T readValue(byte[] content, TypeReference<T> valueTypeRef) throws JacksonException {
        return super.readValue(content, valueTypeRef);
    }

    @Override
    public <T> T readValue(String content, Class<T> valueType) throws JacksonException {
        return super.readValue(content, valueType);
    }

    @Override
    public <T> T readValue(String content, JavaType valueType) throws JacksonException {
        return super.readValue(content, valueType);
    }

    @Override
    public <T> T readValue(String content, TypeReference<T> valueTypeRef) throws JacksonException {
        return super.readValue(content, valueTypeRef);
    }

    @Override
    public <T> T readValue(JsonParser p, Class<T> valueType) throws JacksonException {
        return super.readValue(p, valueType);
    }

    @Override
    public <T> T readValue(JsonParser p, JavaType valueType) throws JacksonException {
        return super.readValue(p, valueType);
    }

    @Override
    public <T> T readValue(JsonParser p, TypeReference<T> valueTypeRef) throws JacksonException {
        return super.readValue(p, valueTypeRef);
    }

    @Override
    public <T> T readValue(DataInput src, Class<T> valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(DataInput src, JavaType valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(DataInput src, TypeReference<T> valueTypeRef) throws JacksonException {
        return super.readValue(src, valueTypeRef);
    }

    @Override
    public <T> T readValue(File src, Class<T> valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(File src, JavaType valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(File src, TypeReference<T> valueTypeRef) throws JacksonException {
        return super.readValue(src, valueTypeRef);
    }

    @Override
    public <T> T readValue(InputStream src, Class<T> valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(InputStream src, JavaType valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(InputStream src, TypeReference<T> valueTypeRef) throws JacksonException {
        return super.readValue(src, valueTypeRef);
    }

    @Override
    public <T> T readValue(Path src, Class<T> valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(Path src, JavaType valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(Path src, TypeReference<T> valueTypeRef) throws JacksonException {
        return super.readValue(src, valueTypeRef);
    }

    @Override
    public <T> T readValue(Reader src, Class<T> valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(Reader src, JavaType valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(Reader src, TypeReference<T> valueTypeRef) throws JacksonException {
        return super.readValue(src, valueTypeRef);
    }

    @Override
    public <T> T readValue(TokenBuffer src, Class<T> valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(TokenBuffer src, JavaType valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(TokenBuffer src, TypeReference<T> valueTypeRef) throws JacksonException {
        return super.readValue(src, valueTypeRef);
    }

    @Override
    public <T> T readValue(URL src, Class<T> valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(URL src, JavaType valueType) throws JacksonException {
        return super.readValue(src, valueType);
    }

    @Override
    public <T> T readValue(URL src, TypeReference<T> valueTypeRef) throws JacksonException {
        return super.readValue(src, valueTypeRef);
    }

    @Override
    public <T> MappingIterator<T> readValues(JsonParser p, Class<T> valueType) throws JacksonException {
        return super.readValues(p, valueType);
    }

    @Override
    public <T> MappingIterator<T> readValues(JsonParser p, JavaType valueType) throws JacksonException {
        return super.readValues(p, valueType);
    }

    @Override
    public <T> MappingIterator<T> readValues(JsonParser p, TypeReference<T> valueType) throws JacksonException {
        return super.readValues(p, valueType);
    }

    /*
    /**********************************************************************
    /* Write methods
    /**********************************************************************
     */

    @Override
    public void writeTree(JsonGenerator g, @Nullable TreeNode rootNode) throws JacksonException {
        super.writeTree(g, rootNode);
    }

    @Override
    public void writeValue(JsonGenerator g, @Nullable Object value) throws JacksonException {
        super.writeValue(g, value);
    }

    @Override
    public void writeValue(File file, @Nullable Object value) throws JacksonException {
        super.writeValue(file, value);
    }

    @Override
    public void writeValue(Path path, @Nullable Object value) throws JacksonException {
        super.writeValue(path, value);
    }

    @Override
    public void writeValue(OutputStream out, @Nullable Object value) throws JacksonException {
        super.writeValue(out, value);
    }

    @Override
    public void writeValue(DataOutput out, @Nullable Object value) throws JacksonException {
        super.writeValue(out, value);
    }

    @Override
    public void writeValue(Writer w, @Nullable Object value) throws JacksonException {
        super.writeValue(w, value);
    }

    @Override
    public String writeValueAsString(@Nullable Object value) throws JacksonException {
        return super.writeValueAsString(value);
    }

    @Override
    public byte[] writeValueAsBytes(@Nullable Object value) throws JacksonException {
        return super.writeValueAsBytes(value);
    }

    @Override
    public TokenBuffer writeValueIntoBuffer(@Nullable Object value) throws JacksonException {
        return super.writeValueIntoBuffer(value);
    }

    @Override
    public JsonParser createParser(byte[] content) throws JacksonException {
        return super.createParser(content);
    }

    @Override
    public JsonParser createParser(byte[] content, int offset, int len) throws JacksonException {
        return super.createParser(content, offset, len);
    }

    /*
    /**********************************************************************
    /* Parser methods
    /**********************************************************************
     */

    @Override
    public JsonParser createParser(char[] content) throws JacksonException {
        return super.createParser(content);
    }

    @Override
    public JsonParser createParser(char[] content, int offset, int len) throws JacksonException {
        return super.createParser(content, offset, len);
    }

    @Override
    public JsonParser createParser(DataInput content) throws JacksonException {
        return super.createParser(content);
    }

    @Override
    public JsonParser createParser(String content) throws JacksonException {
        return super.createParser(content);
    }

    @Override
    public JsonParser createParser(File src) throws JacksonException {
        return super.createParser(src);
    }

    @Override
    public JsonParser createParser(InputStream src) throws JacksonException {
        return super.createParser(src);
    }

    @Override
    public JsonParser createParser(Path src) throws JacksonException {
        return super.createParser(src);
    }

    @Override
    public JsonParser createParser(Reader src) throws JacksonException {
        return super.createParser(src);
    }

    @Override
    public JsonParser createParser(URL src) throws JacksonException {
        return super.createParser(src);
    }

    /*
    /**********************************************************************
    /* Parser methods
    /**********************************************************************
     */

    @Override
    protected ObjectReader _newReader(DeserializationConfig config) {
        return new NullableObjectReader(this, config);
    }
}
