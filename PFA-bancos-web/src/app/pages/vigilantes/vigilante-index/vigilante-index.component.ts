import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Vigilante } from '../../../../models/vigilante';

@Component({
  selector: 'app-vigilante-index',
  templateUrl: './vigilante-index.component.html',
  styleUrls: ['./vigilante-index.component.css']
})
export class VigilanteIndexComponent implements OnInit {

  vigilante: Vigilante;

  constructor(http: Http) {
    http.get("http://localhost:8080/vigilate/1").subscribe(vigilante => {
      this.vigilante = vigilante.json();
    });
  };

  ngOnInit() {
  }

}
