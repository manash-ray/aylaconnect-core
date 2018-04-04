package com.ayla.common.model;

import java.util.List;

public class DiagnosticHistory {
	int total;
	int current_page_number;
	int next_page;
	int start_count_on_page;
	int end_count_on_page;
	
	List<DiagnosticState> diagnostic_states_history;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrent_page_number() {
		return current_page_number;
	}

	public void setCurrent_page_number(int current_page_number) {
		this.current_page_number = current_page_number;
	}

	public int getNext_page() {
		return next_page;
	}

	public void setNext_page(int next_page) {
		this.next_page = next_page;
	}

	public int getStart_count_on_page() {
		return start_count_on_page;
	}

	public void setStart_count_on_page(int start_count_on_page) {
		this.start_count_on_page = start_count_on_page;
	}

	public int getEnd_count_on_page() {
		return end_count_on_page;
	}

	public void setEnd_count_on_page(int end_count_on_page) {
		this.end_count_on_page = end_count_on_page;
	}

	public List<DiagnosticState> getDiagnostic_states_history() {
		return diagnostic_states_history;
	}

	public void setDiagnostic_states_history(List<DiagnosticState> diagnostic_states_history) {
		this.diagnostic_states_history = diagnostic_states_history;
	}




	
	

}
