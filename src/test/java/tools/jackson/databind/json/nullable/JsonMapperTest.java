package tools.jackson.databind.json.nullable;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.ObjectReader;
import tools.jackson.databind.nullable.NullableObjectReader;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class JsonMapperTest {
    @Test
    public void checkReaderIsNullableInstance() {
        ObjectMapper mapper = NullableJsonMapper.builder().build();
        ObjectReader reader = mapper.reader();
        assertInstanceOf(NullableObjectReader.class, reader);
    }
}
