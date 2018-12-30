package com.cw.ref.youtubesearch_duration.provider;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by sodha on 4/3/16.
 */
public class SuggestionProvider extends SearchRecentSuggestionsProvider {
    public final static String AUTHORITY = "com.cw.ref.youtubesearch_duration.provider.SuggestionProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public SuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}
