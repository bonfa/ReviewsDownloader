package fbonfadelli.it.touradvisor.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import fbonfadelli.it.touradvisor.reviews.provider.NetworkReviews;

import static junit.framework.Assert.fail;

public class StubbedReviewsLoader {

    public NetworkReviews loadStubbedReviews() {
        return (NetworkReviews) loadObjectOfTypeFromFileWithName(NetworkReviews.class, "stubbed_reviews.json");
    }

    private Object loadObjectOfTypeFromFileWithName(Class type, String name) {
        String content = loadFileWith(name);
        Gson gson = getGson();
        return gson.fromJson(content, type);
    }

    private String loadFileWith(String fileName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            return new Scanner(file).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
            return null;
        }
    }

    private Gson getGson() {
        return new GsonBuilder().create();
    }


}
