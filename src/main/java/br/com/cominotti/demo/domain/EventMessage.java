package br.com.cominotti.demo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class EventMessage {

    private String name;

    private Integer age;
}
