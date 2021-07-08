package data.dto;



public class AISM_Sheet_Inst_Info_DTO {
	
	private String songId;
	private String instName;
	private String trackNum;
	
	public AISM_Sheet_Inst_Info_DTO() {
		// TODO Auto-generated constructor stub
	}
	public void print() {
		System.out.println(songId);
		System.out.println(instName);
		System.out.println(trackNum);
	}
	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public String getTrackNum() {
		return trackNum;
	}

	public void setTrackNum(String trackNum) {
		this.trackNum = trackNum;
	}

}
	