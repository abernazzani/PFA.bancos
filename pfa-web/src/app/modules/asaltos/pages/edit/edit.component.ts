import { Component, OnInit, Input } from '@angular/core';
import { Asalto } from 'src/app/core/models/asalto';
import { AsaltosService } from 'src/app/core/services/api/asaltos.service';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Location } from '@angular/common';
import { Juez } from 'src/app/core/models/juez';
import { JuecesService } from 'src/app/core/services/api/jueces.service';
import { Sucursal } from 'src/app/core/models/sucursal';
import { SucursalesService } from 'src/app/core/services/api/sucursales.service';
import { Delincuente } from 'src/app/core/models/delincuente';
import { DelincuentesService } from 'src/app/core/services/api/delincuentes.service';
import * as moment from 'moment';

@Component({
    selector: 'asaltos-edit',
    templateUrl: 'edit.component.html'
})

export class AsaltosEditComponent implements OnInit {
    loading: boolean;

    @Input()
    id: number;

    jueces: Juez[];
    sucursales: Sucursal[];

    delincuentes: Delincuente[] = new Array<Delincuente>();

    asalto: Asalto;

    constructor(private asaltosService: AsaltosService,
        private delincuenteService: DelincuentesService,
        private juecesService: JuecesService,
        private sucursalesService: SucursalesService,
        private location: Location,
        private ngbModalService: NgbModal,
        private activatedRoute: ActivatedRoute) { }

    async ngOnInit() {

        this.jueces = await this.juecesService.getAll();
        this.sucursales = await this.sucursalesService.getAll();

        await this.activatedRoute.params.subscribe(async params => {
            this.id = this.id || params["id"];
            if (this.id) {
                this.asalto = await this.asaltosService.getById(this.id);

                this.delincuentes = await this.delincuenteService.getDelincuentesPorAsalto(this.asalto.id);

            } else {
                this.asalto = new Asalto();
                this.asalto.codigoJuez = null;
                this.asalto.codigoSucursal = null;
            }

        });

    }

    async save() {
        debugger;
        if (this.id) {
            await this.asaltosService.update(this.asalto);
        } else {
            await this.asaltosService.create(this.asalto);
        }
        this.location.back();
        // this.activeModal.close(ModalResult.Ok);
    }

    cancel() {
        if (this.ngbModalService.hasOpenModals()) {
            // this.activeModal.close(ModalResult.Cancel);
        } else {
            this.location.back();
        }
    }

    itemsChanged(delincuentes: Delincuente[]) {
        this.asalto.delincuentes = delincuentes.map(x => x.codigo);
    }

    getDate(value: string) {
        var date = moment(value);
        return date.toISOString();
        // return new Date(new Date(value).toTimeString());
    }
}