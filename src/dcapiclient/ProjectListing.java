package dcapiclient;

import com.fasterxml.jackson.annotation.JsonSetter;

public class ProjectListing {

	private String searchTerms;
	private String searchURL;
	private int totalProposals;
	private String[] projects;

	@JsonSetter
	public void setSearchTerms(String searchTerms) {
		this.searchTerms = searchTerms;
	}
	
	@JsonSetter
	public void searchURL(String searchURL) {
		this.searchURL = searchURL;
	}
}