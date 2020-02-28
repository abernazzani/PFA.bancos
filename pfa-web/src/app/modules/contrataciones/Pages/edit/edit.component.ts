import { Component, OnInit, Input } from '@angular/core';
import { ContratacionesService } from 'src/app/core/services/api/contrataciones.service';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Location } from '@angular/common';
import { Contratacion } from 'src/app/core/models/contratacion';
import { Sucursal } from 'src/app/core/models/sucursal';
import { Vigilante } from 'src/app/core/models/vigilante';

@Component({
    selector: 'contrataciones-edit',
    templateUrl: 'edit.component.html'
})

export class ContratacionesEditComponent implements OnInit {
    loading: boolean;

    sucursales: Sucursal[];
    vigilantes: Vigilante[];


    @Input()
    codigo: String;
    fecha: String;




    protected contratacion: Contratacion;

    constructor(private contratacionesService: ContratacionesService,
        private location: Location,
        public activeModal: NgbActiveModal,
        private ngbModalService: NgbModal,
        private activatedRoute: ActivatedRoute) { }

    async ngOnInit() {

        this.sucursales = await this.contratacionesService.traerSucursales();
        this.vigilantes = await this.contratacionesService.traerVigilantes();
        //vigilantes: Vigilante[];


        this.activatedRoute.params.subscribe(async (params) => {
            this.codigo = this.codigo || params["id"];
            if (this.codigo) {
                this.contratacion = await this.contratacionesService.getPorPorFechaYCodVigilante(this.codigo, this.fecha);

            }
            else {
                this.contratacion = new Contratacion();
            }
        });

    }


    async save() {
        console.log(this.contratacion)
        //debugger;
        if (this.codigo) {
            await this.contratacionesService.update(this.contratacion);
        } else {
            await this.contratacionesService.create(this.contratacion);
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

    getEdad(vigilante: Vigilante) {


        let currentDate = new Date();
        let vigilanteDate = new Date(vigilante.fechaNac);
        let edad = currentDate.getFullYear() - vigilanteDate.getFullYear();

        if (currentDate.getMonth() < vigilanteDate.getMonth()) {
            edad = edad - 1;

        } else if (currentDate.getMonth() == vigilanteDate.getMonth()) {
            if (currentDate.getDate() < vigilanteDate.getDate() - 1) {
                edad = edad - 1;
            }
        }

        return edad;
    }
}