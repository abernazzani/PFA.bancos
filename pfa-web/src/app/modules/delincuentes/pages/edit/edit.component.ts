import { Component, OnInit, Input } from '@angular/core';
import { Delincuente } from 'src/app/core/models/delincuente';
import { DelincuentesService } from 'src/app/core/services/api/delincuentes.service';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Location } from '@angular/common';
import { BandasService } from 'src/app/core/services/api/bandas.service';
import { Banda } from 'src/app/core/models/banda';

@Component({
    selector: 'delincuentes-edit',
    templateUrl: 'edit.component.html'
})

export class DelincuentesEditComponent implements OnInit {
    loading: boolean;

    bandas: Banda[];

    @Input()
    codigo: string;

    protected delincuente: Delincuente;

    constructor(private delincuenteService: DelincuentesService,
        private bandasService: BandasService,
        private location: Location,
        public activeModal: NgbActiveModal,
        private ngbModalService: NgbModal,
        private activatedRoute: ActivatedRoute) { }

    async ngOnInit() {
        this.bandas = await this.bandasService.getAll();

        await this.activatedRoute.params.subscribe(async params => {
            this.codigo = this.codigo || params["id"];
            if (this.codigo) {
                this.delincuente = await this.delincuenteService.getByCode(this.codigo);
                debugger;
            } else {
                this.delincuente = new Delincuente();
                this.delincuente.codigoBanda = null;
            }
        });

    }

    async save() {
        debugger;
        if (this.codigo) {
            await this.delincuenteService.update(this.delincuente);
        } else {
            await this.delincuenteService.create(this.delincuente);
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