package Projects;


public class Proposal {
	public String title;
	public String description;
	public int index;
	public ProposalsPane pPane;

	public Proposal(String one) {
		title = one;
		//description = two;
	}
	
	public Proposal() {
	}
	
	public Proposal(ProposalsPane p) {
		pPane = p;
	}
	
/*	public Proposal[] toArray() {
		Proposal[] it = new Proposal[pPane.propList.size()];

		for(int i = 0; i < pPane.propList.size(); i++)

			it[i] = pPane.propList.get(i);

		return it;
	}*/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String des) {
		description = des;
	}
	
	public String toString() {
		return title;
	}
	
	public void setIndex(int n) {
		index = n;
	}
	
	public int getIndex() {
		return index;
	}
}
