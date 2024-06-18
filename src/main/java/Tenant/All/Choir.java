package Tenant.All;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "choirs")
public class Choir {

  @Id
  private String id;
  private String name;
  private List<Singer> singers;

}
