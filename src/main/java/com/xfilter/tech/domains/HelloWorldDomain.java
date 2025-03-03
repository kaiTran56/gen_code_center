package com.xfilter.tech.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class HelloWorldDomain extends BasedDomain<HelloWorldDomain>{
    private String content;
}
