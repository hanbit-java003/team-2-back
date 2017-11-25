package com.hanbit.team2.vo;

import java.util.List;

public class CafeVO {
	private String id;
	private String name;
	private String background;
	private String summary;
	private String areaId;

	private List<ImagesVO> images;
	private List<InfoVO> info;
	private LocationVO location;
	private TrafficVO traffic;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public List<ImagesVO> getImages() {
		return images;
	}
	public void setImages(List<ImagesVO> images) {
		this.images = images;
	}
	public List<InfoVO> getInfo() {
		return info;
	}
	public void setInfo(List<InfoVO> info) {
		this.info = info;
	}
	public LocationVO getLocation() {
		return location;
	}
	public void setLocation(LocationVO location) {
		this.location = location;
	}
	public TrafficVO getTraffic() {
		return traffic;
	}
	public void setTraffic(TrafficVO traffic) {
		this.traffic = traffic;
	}
}
