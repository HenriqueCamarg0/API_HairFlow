package com.HenriqueCamarg0.API_HairFlow.Entity;

public enum Status {
    PENDING,
    CONFIRMED,
    CANCELED,
    COMPLETED,
    NO_SHOW; // Ausente (não compareceu) - opcional, dependendo do seu fluxo de trabalho
}
