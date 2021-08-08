package com.maxsuel.api.controller.form;

import javax.validation.constraints.NotNull;

public class UpdateCategoriaForm extends CategoriaForm {

    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }
}
