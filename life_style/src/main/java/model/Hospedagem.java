package model;

public class Hospedagem {
	private int id;
	private String nomeHotel;
	private String endereco;
	private String estado;
	private String valor;
	private String checkIn;
	private String checkOut;
	private String telefoneHotel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeHotel() {
		return nomeHotel;
	}
	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public String getTelefoneHotel() {
		return telefoneHotel;
	}
	public void setTelefoneHotel(String telefoneHotel) {
		this.telefoneHotel = telefoneHotel;
	}
	@Override
	public String toString() {
		return "Hospedagem [id=" + id + ", nomeHotel=" + nomeHotel + ", endereco=" + endereco + ", estado=" + estado
				+ ", valor=" + valor + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", telefoneHotel="
				+ telefoneHotel + "]";
	}
	
	
}
