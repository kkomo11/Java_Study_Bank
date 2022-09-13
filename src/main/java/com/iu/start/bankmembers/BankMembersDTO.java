package com.iu.start.bankmembers;

import java.util.List;

import com.iu.start.bankaccount.BankAccountDTO;

public class BankMembersDTO {
	private String userName;
	private String passWord;
	private String name;
	private String email;
	private String phone;
	private List<BankAccountDTO> bankAccountDTOs;
	private BankMembersFileDTO bankMembersFileDTO;
	private List<RoleDTO> RoleDTOs;
	
	public List<RoleDTO> getRoleDTOs() {
		return RoleDTOs;
	}

	public void setRoleDTOs(List<RoleDTO> roleDTOs) {
		RoleDTOs = roleDTOs;
	}

	public BankMembersFileDTO getBankMembersFileDTO() {
		return bankMembersFileDTO;
	}

	public void setBankMembersFileDTO(BankMembersFileDTO bankMembersFileDTO) {
		this.bankMembersFileDTO = bankMembersFileDTO;
	}

	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}
	
	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTO) {
		this.bankAccountDTOs = bankAccountDTO;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}