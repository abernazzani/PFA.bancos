import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
mostrar = true;
texto = 'ocultar';
  title = 'PFA-bancos-web';

  mostrarBoton() {
    if(this.mostrar)
    this.texto='mostrar';
    else
    this.texto='ocultar';
    
this.mostrar =!this.mostrar;


  }
}