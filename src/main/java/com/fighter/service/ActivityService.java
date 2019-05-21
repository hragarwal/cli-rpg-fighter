package com.fighter.service;

import com.fighter.model.Activity;
import com.fighter.service.file.FileStore;

public class ActivityService {

    private FileStore fileStore;

    public ActivityService(FileStore fileStore) {
        this.fileStore = fileStore;
    }

    public Activity getActivity() {
        return fileStore.deserialize();
    }

    public boolean saveActivity(Activity activity) {
        return fileStore.serialize(activity);
    }
}
