package tools.jackson.databind.nullable;

import org.jspecify.annotations.Nullable;
import tools.jackson.core.*;
import tools.jackson.core.type.ResolvedType;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.*;
import tools.jackson.databind.cfg.ContextAttributes;
import tools.jackson.databind.cfg.DatatypeFeature;
import tools.jackson.databind.deser.DeserializationProblemHandler;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.JsonNodeFactory;
import tools.jackson.databind.node.ObjectNode;
import tools.jackson.databind.type.TypeFactory;
import tools.jackson.databind.util.TokenBuffer;

import java.io.DataInput;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class NullableObjectReader extends ObjectReader {

    public NullableObjectReader(ObjectMapper mapper, DeserializationConfig config) {
        super(mapper, config);
    }

    protected NullableObjectReader(ObjectReader reader, DeserializationConfig config) {
        super(reader, config);
    }

    protected NullableObjectReader(ObjectReader base, DeserializationConfig config,
                                   @Nullable JavaType valueType,
                                   @Nullable ValueDeserializer<Object> rootDeser,
                                   @Nullable Object valueToUpdate,
                                   @Nullable FormatSchema schema,
                                   @Nullable InjectableValues injectableValues) {
        super(base, config, valueType, rootDeser, valueToUpdate, schema, injectableValues);
    }

    @Override
    public ObjectReader at(JsonPointer pointer) {
        return super.at(pointer);
    }

    @Override
    public ObjectReader at(String pointerExpr) {
        return super.at(pointerExpr);
    }

    @Override
    public JsonNode booleanNode(boolean b) {
        return super.booleanNode(b);
    }

    @Override
    public ArrayNode createArrayNode() {
        return super.createArrayNode();
    }

    @Override
    public JsonParser createNonBlockingByteArrayParser() throws JacksonException {
        return super.createNonBlockingByteArrayParser();
    }

    @Override
    public JsonParser createNonBlockingByteBufferParser() throws JacksonException {
        return super.createNonBlockingByteBufferParser();
    }

    @Override
    public ObjectNode createObjectNode() {
        return super.createObjectNode();
    }

    @Override
    public JsonParser createParser(byte[] content) throws JacksonException {
        return super.createParser(content);
    }

    @Override
    public JsonParser createParser(byte[] content, int offset, int len) throws JacksonException {
        return super.createParser(content, offset, len);
    }

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

    @Override
    public NullableObjectReader forType(Class<?> valueType) {
        return forType(_config.constructType(valueType));
    }

    @Override
    public NullableObjectReader forType(@Nullable JavaType valueType) {
        if (valueType != null && valueType.equals(_valueType)) {
            return this;
        }
        ValueDeserializer<Object> rootDeser = _prefetchRootDeserializer(valueType);
        return _new(this, _config, valueType, rootDeser,
                _valueToUpdate, _schema, _injectableValues);
    }

    @Override
    public NullableObjectReader forType(TypeReference<?> valueTypeRef) {
        return forType(_config.getTypeFactory().constructType(valueTypeRef.getType()));
    }

    @Override
    public ContextAttributes getAttributes() {
        return super.getAttributes();
    }

    @Override
    public DeserializationConfig getConfig() {
        return super.getConfig();
    }

    @Override
    public InjectableValues getInjectableValues() {
        return super.getInjectableValues();
    }

    @Override
    public JavaType getValueType() {
        return super.getValueType();
    }

    @Override
    public boolean isEnabled(DatatypeFeature f) {
        return super.isEnabled(f);
    }

    @Override
    public boolean isEnabled(DeserializationFeature f) {
        return super.isEnabled(f);
    }

    @Override
    public boolean isEnabled(MapperFeature f) {
        return super.isEnabled(f);
    }

    @Override
    public boolean isEnabled(StreamReadFeature f) {
        return super.isEnabled(f);
    }

    @Override
    public JsonNode missingNode() {
        return super.missingNode();
    }

    @Override
    public JsonNode nullNode() {
        return super.nullNode();
    }

    @Override
    public TokenStreamFactory parserFactory() {
        return super.parserFactory();
    }

    @Override
    public JsonNode readTree(byte[] content) throws JacksonException {
        return super.readTree(content);
    }

    @Override
    public JsonNode readTree(byte[] content, int offset, int len) throws JacksonException {
        return super.readTree(content, offset, len);
    }

    @Override
    public JsonNode readTree(DataInput content) throws JacksonException {
        return super.readTree(content);
    }

    @Override
    public JsonNode readTree(String content) throws JacksonException {
        return super.readTree(content);
    }

    @Override
    public JsonNode readTree(JsonParser p) throws JacksonException {
        return super.readTree(p);
    }

    @Override
    public JsonNode readTree(InputStream src) throws JacksonException {
        return super.readTree(src);
    }

    @Override
    public JsonNode readTree(Reader src) throws JacksonException {
        return super.readTree(src);
    }

    @Override
    public JsonNode readTree(TokenBuffer src) throws JacksonException {
        return super.readTree(src);
    }

    @Override
    public <T> T readValue(byte[] buffer, int offset, int length) throws JacksonException {
        return super.readValue(buffer, offset, length);
    }

    @Override
    public <T> T readValue(byte[] content) throws JacksonException {
        return super.readValue(content);
    }

    @Override
    public <T> T readValue(String content) throws JacksonException {
        return super.readValue(content);
    }

    @Override
    public <T> T readValue(File f) throws JacksonException {
        return super.readValue(f);
    }

    @Override
    public <T> T readValue(InputStream in) throws JacksonException {
        return super.readValue(in);
    }

    @Override
    public <T> T readValue(DataInput input) throws JacksonException {
        return super.readValue(input);
    }

    @Override
    public <T> T readValue(JsonNode node) throws JacksonException {
        return super.readValue(node);
    }

    @Override
    public <T> T readValue(JsonParser p) throws JacksonException {
        return super.readValue(p);
    }

    @Override
    public <T> T readValue(Path path) throws JacksonException {
        return super.readValue(path);
    }

    @Override
    public <T> T readValue(Reader r) throws JacksonException {
        return super.readValue(r);
    }

    @Override
    public <T> T readValue(TokenBuffer src) throws JacksonException {
        return super.readValue(src);
    }

    @Override
    public <T> T readValue(URL url) throws JacksonException {
        return super.readValue(url);
    }

    @Override
    public <T> MappingIterator<T> readValues(byte[] content, int offset, int length) throws JacksonException {
        return super.readValues(content, offset, length);
    }

    @Override
    public <T> MappingIterator<T> readValues(String content) throws JacksonException {
        return super.readValues(content);
    }

    @Override
    public <T> MappingIterator<T> readValues(JsonParser p) throws JacksonException {
        return super.readValues(p);
    }

    @Override
    public <T> Iterator<T> readValues(JsonParser p, Class<T> valueType) throws JacksonException {
        return super.readValues(p, valueType);
    }

    @Override
    public <T> Iterator<T> readValues(JsonParser p, JavaType valueType) throws JacksonException {
        return super.readValues(p, valueType);
    }

    @Override
    public <T> Iterator<T> readValues(JsonParser p, ResolvedType valueType) throws JacksonException {
        return super.readValues(p, valueType);
    }

    @Override
    public <T> Iterator<T> readValues(JsonParser p, TypeReference<T> valueTypeRef) throws JacksonException {
        return super.readValues(p, valueTypeRef);
    }

    @Override
    public <T> MappingIterator<T> readValues(DataInput src) throws JacksonException {
        return super.readValues(src);
    }

    @Override
    public <T> MappingIterator<T> readValues(File src) throws JacksonException {
        return super.readValues(src);
    }

    @Override
    public <T> MappingIterator<T> readValues(InputStream src) throws JacksonException {
        return super.readValues(src);
    }

    @Override
    public <T> MappingIterator<T> readValues(Reader src) throws JacksonException {
        return super.readValues(src);
    }

    @Override
    public <T> MappingIterator<T> readValues(Path src) throws JacksonException {
        return super.readValues(src);
    }

    @Override
    public <T> MappingIterator<T> readValues(TokenBuffer src) throws JacksonException {
        return super.readValues(src);
    }

    @Override
    public <T> MappingIterator<T> readValues(URL src) throws JacksonException {
        return super.readValues(src);
    }

    @Override
    public JsonNode stringNode(String text) {
        return super.stringNode(text);
    }

    @Override
    public JsonParser treeAsTokens(TreeNode n) {
        return super.treeAsTokens(n);
    }

    @Override
    public <T> T treeToValue(TreeNode n, Class<T> valueType) throws JacksonException {
        return super.treeToValue(n, valueType);
    }

    @Override
    public <T> T treeToValue(TreeNode n, JavaType valueType) throws JacksonException {
        return super.treeToValue(n, valueType);
    }

    @Override
    public TypeFactory typeFactory() {
        return super.typeFactory();
    }

    @Override
    public Version version() {
        return super.version();
    }

    @Override
    public ObjectReader with(ContextAttributes attrs) {
        return super.with(attrs);
    }

    @Override
    public ObjectReader with(DeserializationConfig config) {
        return super.with(config);
    }

    @Override
    public ObjectReader with(Base64Variant defaultBase64) {
        return super.with(defaultBase64);
    }

    @Override
    public ObjectReader with(JsonNodeFactory f) {
        return super.with(f);
    }

    @Override
    public NullableObjectReader with(DatatypeFeature feature) {
        return withConfig(_config.with(feature));
    }

    @Override
    public NullableObjectReader with(DeserializationFeature feature) {
        return withConfig(_config.with(feature));
    }

    @Override
    public NullableObjectReader with(FormatFeature feature) {
        return withConfig(_config.with(feature));
    }

    @Override
    public NullableObjectReader with(StreamReadFeature feature) {
        return withConfig(_config.with(feature));
    }

    @Override
    public NullableObjectReader with(DeserializationFeature first, DeserializationFeature... other) {
        return withConfig(_config.with(first, other));
    }

    @Override
    public NullableObjectReader with(InjectableValues injectableValues) {
        if (_injectableValues == injectableValues) {
            return this;
        }
        return _new(this, _config,
                _valueType, _rootDeserializer, _valueToUpdate,
                _schema, injectableValues);
    }

    @Override
    public ObjectReader with(Locale l) {
        return super.with(l);
    }

    @Override
    public ObjectReader with(FormatSchema schema) {
        return super.with(schema);
    }

    @Override
    public ObjectReader with(TimeZone tz) {
        return super.with(tz);
    }

    @Override
    public ObjectReader withAttribute(Object key, Object value) {
        return super.withAttribute(key, value);
    }

    @Override
    public ObjectReader withAttributes(Map<?, ?> attrs) {
        return super.withAttributes(attrs);
    }

    @Override
    public NullableObjectReader withFeatures(DatatypeFeature... features) {
        return withConfig(_config.withFeatures(features));
    }

    @Override
    public NullableObjectReader withFeatures(DeserializationFeature... features) {
        return withConfig(_config.withFeatures(features));
    }

    @Override
    public NullableObjectReader withFeatures(FormatFeature... features) {
        return withConfig(_config.withFeatures(features));
    }

    @Override
    public NullableObjectReader withFeatures(StreamReadFeature... features) {
        return withConfig(_config.withFeatures(features));
    }

    @Override
    public ObjectReader withHandler(DeserializationProblemHandler h) {
        return super.withHandler(h);
    }

    @Override
    public ObjectReader without(DatatypeFeature feature) {
        return super.without(feature);
    }

    @Override
    public ObjectReader without(DeserializationFeature feature) {
        return super.without(feature);
    }

    @Override
    public ObjectReader without(FormatFeature feature) {
        return super.without(feature);
    }

    @Override
    public ObjectReader without(StreamReadFeature feature) {
        return super.without(feature);
    }

    @Override
    public ObjectReader without(DeserializationFeature first, DeserializationFeature... other) {
        return super.without(first, other);
    }

    @Override
    public ObjectReader withoutAttribute(Object key) {
        return super.withoutAttribute(key);
    }

    @Override
    public ObjectReader withoutFeatures(DatatypeFeature... features) {
        return super.withoutFeatures(features);
    }

    @Override
    public ObjectReader withoutFeatures(DeserializationFeature... features) {
        return super.withoutFeatures(features);
    }

    @Override
    public ObjectReader withoutFeatures(FormatFeature... features) {
        return super.withoutFeatures(features);
    }

    @Override
    public ObjectReader withoutFeatures(StreamReadFeature... features) {
        return super.withoutFeatures(features);
    }

    @Override
    public ObjectReader withoutRootName() {
        return super.withoutRootName();
    }

    @Override
    public NullableObjectReader withRootName(@Nullable PropertyName rootName) {
        return withConfig(_config.withRootName(rootName));
    }

    @Override
    public NullableObjectReader withRootName(@Nullable String rootName) {
        return withConfig(_config.withRootName(rootName));
    }

    @Override
    public NullableObjectReader withValueToUpdate(@Nullable Object value) {
        if (value == _valueToUpdate) return this;
        if (value == null) {
            // 18-Oct-2016, tatu: Actually, should be allowed, to remove value
            //   to update, if any
            return _new(this, _config, _valueType, _rootDeserializer, null,
                    _schema, _injectableValues);
        }
        JavaType t;

        /* no real benefit from pre-fetching, as updating readers are much
         * less likely to be reused, and value type may also be forced
         * with a later chained call...
         */
        if (_valueType == null) {
            t = _config.constructType(value.getClass());
        } else {
            t = _valueType;
        }
        return _new(this, _config, t, _rootDeserializer, value,
                _schema, _injectableValues);
    }

    @Override
    public ObjectReader withView(Class<?> activeView) {
        return super.withView(activeView);
    }

    @Override
    public void writeTree(JsonGenerator g, TreeNode tree) {
        super.writeTree(g, tree);
    }

    /*
    /**********************************************************************
    /* Internal factory methods
    /**********************************************************************
     */

    protected NullableObjectReader _new(ObjectReader base, DeserializationConfig config,
                                        @Nullable JavaType valueType,
                                        @Nullable ValueDeserializer<Object> rootDeser,
                                        @Nullable Object valueToUpdate,
                                        @Nullable FormatSchema schema,
                                        @Nullable InjectableValues injectableValues) {
        return new NullableObjectReader(base, config, valueType, rootDeser, valueToUpdate,
                schema, injectableValues);
    }

    protected NullableObjectReader withConfig(DeserializationConfig newConfig) {
        if (newConfig == _config) {
            return this;
        }
        return new NullableObjectReader(this, newConfig);
    }

}
