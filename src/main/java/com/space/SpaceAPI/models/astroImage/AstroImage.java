package com.space.SpaceAPI.models.astroImage;

import java.util.List;

public class AstroImage {
    private AstroImageUtilCollection collection;

    public AstroImage() {}

    public AstroImage(AstroImageUtilCollection collection) {
        this.collection = collection;
    }

    public AstroImageUtilCollection getCollection() {
        return collection;
    }

    public void setCollection(AstroImageUtilCollection collection) {
        this.collection = collection;
    }

    public static AstroImage getDefaultImage(){
        AstroImageUtilData data = new AstroImageUtilData();
        data.setTitle("Image not found");
        AstroImageUtilItems items = new AstroImageUtilItems();
        items.setData(List.of(data));
        AstroImageUtilCollection collection = new AstroImageUtilCollection(List.of(items));
        return new AstroImage(collection);
    }
}
