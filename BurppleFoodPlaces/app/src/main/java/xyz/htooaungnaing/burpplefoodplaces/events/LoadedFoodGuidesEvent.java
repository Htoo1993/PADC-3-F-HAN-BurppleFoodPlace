package xyz.htooaungnaing.burpplefoodplaces.events;

import java.util.List;

import xyz.htooaungnaing.burpplefoodplaces.data.vo.GuidesVO;

/**
 * Created by htoo on 1/13/2018.
 */

public class LoadedFoodGuidesEvent {

    private List<GuidesVO>  guidesVOList;

    public LoadedFoodGuidesEvent(List<GuidesVO> guidesVOList) {
        this.guidesVOList = guidesVOList;
    }

    public List<GuidesVO> getGuidesVOList() {
        return guidesVOList;
    }
}
