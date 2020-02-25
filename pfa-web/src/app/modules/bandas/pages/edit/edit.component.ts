import { Component, OnInit, Input } from '@angular/core';
import { Banda } from 'src/app/core/models/banda';
import { BandasService } from 'src/app/core/services/api/bandas.service';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Location } from '@angular/common';

@Component({
    selector: 'bandas-edit',
    templateUrl: 'edit.component.html'
})

export class BandasEditComponent implements OnInit {
    loading: boolean;

    @Input()
    codigo: string;

    banda: Banda;

    constructor(private bandasService: BandasService,
        private location: Location,
        public activeModal: NgbActiveModal,
        private ngbModalService: NgbModal,
        private activatedRoute: ActivatedRoute) { }

    async ngOnInit() {
        await this.activatedRoute.params.subscribe(async params => {
            this.codigo = this.codigo || params["id"];
            if (this.codigo) {
                this.banda = await this.bandasService.getPorCodigo(this.codigo);
            } else {
                this.banda = new Banda();
            }
        });

    }

    async save() {
        debugger;
        if (this.codigo) {
            await this.bandasService.update(this.banda);
        } else {
            await this.bandasService.create(this.banda);
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