package com.Disponibilite.Disponibilite.disponibilite;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class disponibilteDto {
    @NotNull
    @NotEmpty
    private Date date_dispo;

    public @NotNull @NotEmpty Date getDate_dispo() {
        return date_dispo;
    }

    public void setDate_dispo(@NotNull @NotEmpty Date date_dispo) {
        this.date_dispo = date_dispo;
    }
}
