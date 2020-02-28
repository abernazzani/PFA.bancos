import { Component, OnInit, Input } from '@angular/core';
import { CondenasService } from 'src/app/core/services/api/condenas.service';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Location } from '@angular/common';
import { Condena} from 'src/app/core/models/condena';
import { Sucursal } from 'src/app/core/models/sucursal';
import { Vigilante } from 'src/app/core/models/vigilante';

@Component({
    selector: 'condenas-edit',
    templateUrl: 'edit.component.html'
})

export class CondenasEditComponent implements OnInit {
    loading: boolean;

    //sucursales: Sucursal[];
    //vigilantes: Vigilante[];


    @Input()
    codigo: String;
    codigoA: number;//fecha: Date;




    condena: Condena;

    constructor(private condenasService: CondenasService,
        private location: Location,
        public activeModal: NgbActiveModal,
        private ngbModalService: NgbModal,
        private activatedRoute: ActivatedRoute) { }

    async ngOnInit() {

        //this.sucursales = await this.condenasService.traerSucursales(); 
        //this.vigilantes = await this.condenasService.traerVigilantes(); 
        //vigilantes: Vigilante[];

       
        this.activatedRoute.params.subscribe(async (params) => {
            this.codigo = this.codigo || params["id"];
            if (this.codigo) {
               
               
                this.condena = await this.condenasService.getPorDelincuenteyAsalto(this.codigo, this.codigoA);
            
            }
            else {
                this.condena = new Condena();
            }
        });

    }


    async save() {
        console.log(this.condena)
         //debugger;
         if (this.codigo) {
             await this.condenasService.update(this.condena);
         } else {
             await this.condenasService.create(this.condena);
         }
         this.activeModal.close(ModalResult.Ok);
        


    }


    cancel() {
         if (this.ngbModalService.hasOpenModals()) {
             this.activeModal.close(ModalResult.Cancel);
         } else {
             this.location.back();
         }
    }
    
}