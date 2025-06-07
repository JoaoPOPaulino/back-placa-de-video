package br.unitins.back.dto.request.pagamento;

import jakarta.validation.constraints.NotBlank;

public class CustomerDTO {

    @NotBlank(message = "O nome do cliente é obrigatório.")
    private String name;

    @NotBlank(message = "O email do cliente é obrigatório.")
    private String email;

    @NotBlank(message = "O telefone do cliente é obrigatório.")
    private String cellphone;

    @NotBlank(message = "O CPF/CNPJ do cliente é obrigatório.")
    private String taxId;

    // Getters e setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCellphone() { return cellphone; }
    public void setCellphone(String cellphone) { this.cellphone = cellphone; }

    public String getTaxId() { return taxId; }
    public void setTaxId(String taxId) { this.taxId = taxId; }
}
