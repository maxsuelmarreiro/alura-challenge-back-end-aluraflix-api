package com.maxsuel.api.controller.form;

import javax.validation.constraints.NotNull;

public class UpdateVideoForm extends VideoForm {

    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

}
