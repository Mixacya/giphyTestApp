package com.gettyimage.gettyimagetestapp.db;

import com.gettyimage.gettyimagetestapp.db.dao.GifInfo;
import com.gettyimage.gettyimagetestapp.db.dao.SearchHistory;
import com.gettyimage.gettyimagetestapp.rest.dto.Data;
import com.gettyimage.gettyimagetestapp.rest.dto.ImageResponse;
import com.gettyimage.gettyimagetestapp.rest.dto.SearchImagesResponse;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;

public class DBManager {

    public static class SingletonDB {
        public static DBManager instance = new DBManager();
    }

    public static DBManager getInstance() {
        return SingletonDB.instance;
    }

    private <T extends RealmObject> long getMaxId(Class<T> clazz) {
        long id;
        final Realm realm = Realm.getDefaultInstance();
        final Number number = realm.where(clazz).max("realmId");
        id = number == null ? 0 : number.longValue() + 1;
        return id;
    }

    private <T extends RealmObject> T createRealmObject(Class<T> clazz) {
        return Realm.getDefaultInstance().createObject(clazz, getMaxId(clazz));
    }

    private <T extends RealmObject> List<T> getObjectList(Class<T> clazz) {
        return Realm.getDefaultInstance().where(clazz).findAll();
    }

    public List<SearchHistory> getHistoryList() {
        return getObjectList(SearchHistory.class);
    }

    public void saveGif(final Data data, final String searchWord) {
        if (searchWord != null && !searchWord.isEmpty()) {
            if (!isContains(searchWord)) {
                Realm.getDefaultInstance().beginTransaction();
                final SearchHistory searchHistory = createRealmObject(SearchHistory.class);
                searchHistory.setSearchWord(searchWord);
                searchHistory.setInfo(createGif(data));
                Realm.getDefaultInstance().commitTransaction();
            }
        }
    }

    private GifInfo createGif(final Data data) {
        final GifInfo gif = createRealmObject(GifInfo.class);
        if (data != null) {
            final ImageResponse response = data.getImage().getOriginal();
            gif.setTitle(data.getTitle());
            gif.setType(data.getType());
            gif.setWidth(response.getWidth());
            gif.setHeight(response.getHeight());
            gif.setSize(response.getSize());
            gif.setUrl(response.getUrl());
        }
        return gif;
    }

    private boolean isContains(final String search) {
        boolean contains = false;
        final Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        final SearchHistory history = realm.where(SearchHistory.class)
                .equalTo(SearchHistory.Columns.SEARCH_WORD, search).findFirst();
        if (history != null) {
            contains = true;
        }
        realm.commitTransaction();
        return contains;
    }

}
