package utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataModel {
    public Node[] node;
}

class Node{
    private String name;
    private String type;
    private String identifier;
}