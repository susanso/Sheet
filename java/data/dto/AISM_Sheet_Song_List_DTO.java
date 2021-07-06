package data.dto;



import java.util.List;

import data.dto.AISM_Sheet_Song_Info_DTO;
import data.dto.AISM_Sheet_Inst_Info_DTO;
import data.dto.AISM_Sheet_Chord_Info_DTO;

public class AISM_Sheet_Song_List_DTO {
	private AISM_Sheet_Song_Info_DTO songInfo;
	private List<AISM_Sheet_Inst_Info_DTO> instList;
	private List<AISM_Sheet_Chord_Info_DTO> chordList;
	
	
	
	public AISM_Sheet_Song_List_DTO() {
		
	}
	
	public AISM_Sheet_Song_Info_DTO getSongInfo() {
		return songInfo;
	}
	
	public void setSongInfo(AISM_Sheet_Song_Info_DTO songInfo) {
		this.songInfo = songInfo;
	}
	
	public List<AISM_Sheet_Inst_Info_DTO> getInstList() {
		return instList;
	}
	
	public void setInstList(List<AISM_Sheet_Inst_Info_DTO> instList) {
		this.instList = instList;
	}
	
	public List<AISM_Sheet_Chord_Info_DTO> getChordList() {
		return chordList;
	}
	
	public void setChordList(List<AISM_Sheet_Chord_Info_DTO> chordList) {
		this.chordList = chordList;
	}
	
}
