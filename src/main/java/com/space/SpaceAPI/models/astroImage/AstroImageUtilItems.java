package com.space.SpaceAPI.models.astroImage;

import java.util.List;

public class AstroImageUtilItems {
    List<AstroImageUtilData> data;
    List<AstroImageUtilLinks> links;

    public AstroImageUtilItems() {
    }

    public AstroImageUtilItems(List<AstroImageUtilData> data, List<AstroImageUtilLinks> links) {
        this.data = data;
        this.links = links;
    }

    public List<AstroImageUtilData> getData() {
        return data;
    }

    public void setData(List<AstroImageUtilData> data) {
        this.data = data;
    }

    public List<AstroImageUtilLinks> getLinks() {
        return links;
    }

    public void setLinks(List<AstroImageUtilLinks> links) {
        this.links = links;
    }
}
