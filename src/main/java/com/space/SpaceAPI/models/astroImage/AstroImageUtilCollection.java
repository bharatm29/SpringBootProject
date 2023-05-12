package com.space.SpaceAPI.models.astroImage;

import java.util.List;

public class AstroImageUtilCollection {
    private List<AstroImageUtilItems> items;

    public AstroImageUtilCollection() {
    }

    public AstroImageUtilCollection(List<AstroImageUtilItems> items) {
        this.items = items;
    }

    public List<AstroImageUtilItems> getItems() {
        return items;
    }

    public void setItems(List<AstroImageUtilItems> items) {
        this.items = items;
    }
}
