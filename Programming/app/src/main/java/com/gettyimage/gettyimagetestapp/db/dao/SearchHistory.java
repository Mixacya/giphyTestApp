package com.gettyimage.gettyimagetestapp.db.dao;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SearchHistory extends RealmObject {

    public static final class Columns {
        public static final String REALM_ID = "realmId";
        public static final String SEARCH_WORD = "searchWord";
        public static final String GIF_INFO = "info";
    }

    @PrimaryKey
    private long realmId;
    private String searchWord;
    private GifInfo info;

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(final String searchWord) {
        this.searchWord = searchWord;
    }

    public GifInfo getInfo() {
        return info;
    }

    public void setInfo(final GifInfo info) {
        this.info = info;
    }
}
