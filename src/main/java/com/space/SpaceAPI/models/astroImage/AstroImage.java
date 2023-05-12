package com.space.SpaceAPI.models.astroImage;

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
}
