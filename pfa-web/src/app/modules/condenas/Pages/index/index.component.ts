import { Component, OnInit } from '@angular/core';
import { Condena} from 'src/app/core/models/condena';
import { CondenasService } from 'src/app/core/services/api/condenas.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { CondenasEditComponent } from '../edit/edit.component';
import { AuthService } from 'src/app/core/services/api/auth.service';
import { Vigilante } from 'src/app/core/models/vigilante';

@Component({
    selector: 'condenas-index',
    templateUrl: 'index.component.html'
})

export class CondenasIndexComponent implements OnInit {
    condenas : Condena[];
    vigilante : Vigilante;
    vigiCodigo: String;

    constructor(private condenasService: CondenasService,
        private modalService: NgbModal,public authService: AuthService) {
    }

    async ngOnInit() {
               
        this.getAll();
    }

    async getAll() {
        this.condenas = await this.condenasService.getAll();
       
    }

    async edit(condena: Condena) {
        //debugger;
        //console.log(condena);
        const modalRef = this.modalService.open(CondenasEditComponent);

        if (condena) {
            modalRef.componentInstance.codigo = condena.codigoDelincuente;
           modalRef.componentInstance.codigoA = condena.codigoAsalto;
        }

        var result = await modalRef.result;
        if (result == ModalResult.Ok) {
            this.getAll();
        }
    
    }

    async delete($event, condena: Condena) {
        debugger;

        await this.condenasService.delete(condena.codigoDelincuente, condena.codigoAsalto);
        this.getAll();
        $event.stopPropagation();
    }

    getCantDias(condena: Condena){

        
        let fechaDeInicio = new Date(condena.fechaDeInicio);
        let fechaFin = new Date(condena.fechaFin);
        
        let calculoAnios: Number;
        let calculoMeses: Number;
        let calculoDias: Number;


        calculoAnios = (fechaFin.getFullYear() - fechaDeInicio.getFullYear())*365;
        calculoMeses = (fechaFin.getMonth() - fechaDeInicio.getMonth())*30;
        calculoDias = (fechaFin.getDate() - fechaDeInicio.getDate());

        return (calculoAnios.valueOf() + calculoMeses.valueOf() + calculoDias.valueOf());
    }
        
}