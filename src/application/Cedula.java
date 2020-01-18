package application;

public class Cedula {
	
	private Integer codigo;
	private String cedula;
	private Double valor;
	private Integer quantidade;
	private Double valorTotal;
	
	public Cedula() {
		// TODO Auto-generated constructor stub
	}
	
	public Cedula(Integer codigo, String cedula, Double valor, Integer quantidade, Double valorTotal) {
		super();
		this.codigo = codigo;
		this.cedula = cedula;
		this.valor = valor;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	@Override
	public String toString() {
		return "Cedula [codigo=" + codigo + ", cedula=" + cedula + ", valor=" + valor + ", quantidade=" + quantidade
				+ ", valorTotal=" + valorTotal + "]";
	}
	
	

}
