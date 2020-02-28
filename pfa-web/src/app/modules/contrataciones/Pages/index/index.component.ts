import { Component, OnInit } from '@angular/core';
import { Contratacion} from 'src/app/core/models/contratacion';
import { ContratacionesService } from 'src/app/core/services/api/contrataciones.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { ContratacionesEditComponent } from '../edit/edit.component';
import { AuthService } from 'src/app/core/services/api/auth.service';
import { Vigilante } from 'src/app/core/models/vigilante';

@Component({
    selector: 'contrataciones-index',
    templateUrl: 'index.component.html'
})

export class ContratacionesIndexComponent implements OnInit {
    contrataciones : Contratacion[];
    vigilante : Vigilante;
    vigiCodigo: String;

    constructor(private contratacionesService: ContratacionesService,
        private modalService: NgbModal,public authService: AuthService) {
    }

    async ngOnInit() {
               
        this.getAll();
    }

    async getAll() {
        this.contrataciones = await this.contratacionesService.getAll();
        
        if (this.authService.currentUser.rolID == 2){
        
        let usuario = this.authService.currentUser.nombre.toString();
        this.vigilante = await this.contratacionesService.traerVigilante(usuario);
        this.vigiCodigo = this.vigilante.codigo;
        }

    }

    async edit(contratacion: Contratacion) {
        //debugger;
        console.log(contratacion);
        const modalRef = this.modalService.open(ContratacionesEditComponent);

        if (contratacion) {
            modalRef.componentInstance.codigo = contratacion.codigoVigilante;
            modalRef.componentInstance.fecha = contratacion.fecha;
        }

        var result = await modalRef.result;
        if (result == ModalResult.Ok) {
            this.getAll();
        }
    
    }

    async delete($event, contratacion: Contratacion) {
        debugger;

        await this.contratacionesService.delete(contratacion.codigoVigilante, contratacion.fecha);
        this.getAll();
        $event.stopPropagation();
    }
        
}