package com.space.SpaceAPI.models.astroImage;

import java.util.List;

public class AstroImageUtilItems {
    List<AstroImageUtilData> data;
    String href;

    public AstroImageUtilItems() {}

    public AstroImageUtilItems(List<AstroImageUtilData> data, String href) {
        this.data = data;
        this.href = href;
    }

    public List<AstroImageUtilData> getData() {
        return data;
    }

    public void setData(List<AstroImageUtilData> data) {
        this.data = data;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
