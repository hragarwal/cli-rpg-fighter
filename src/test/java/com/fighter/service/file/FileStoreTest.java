package com.fighter.service.file;

import com.fighter.model.Activity;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.fighter.utils.PlayerUtils.createCharacter;
import static com.fighter.utils.PlayerUtils.createMonster;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FileStoreTest {

    private FileStore fileStore;

    @Before
    public void setup() {
        fileStore = new FileStore();
    }

    @Test
    public void shouldSerializeObject() throws IOException {
        Activity activity = new Activity(createCharacter("Meow"),
                createMonster("Godzilla"));
        final Boolean serializationDone = fileStore.serialize(activity);
        assertTrue(serializationDone);
    }

    @Test
    public void shouldDeserializeObject() {
        Activity activity = fileStore.deserialize();
        assertNotNull(activity);
    }


}