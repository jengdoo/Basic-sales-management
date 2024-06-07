<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <style>
        .nav-item a:hover {
            background-color: dodgerblue;
        }
    </style>
</head>
<body>
    <div class="d-flex">
        <div style="width: 300px;background-color:#CCCCFF;min-height: 900px">
            <div class="text-center">
            <a href=""><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAATwAAACgCAMAAACmCCC4AAABHVBMVEX///8AAAD+/v7uAGr9/P786/LJHGf8///5///7+/v3///29vb///7y8vLu7u7p6enZ2dnj4+PMzMwjIyOqqqrU1NSjo6NxcXG+vr4QEBC0tLRbW1vExMSMjIwyMjK7u7uEhIRQUFA+Pj5mZmZGRkabm5uSkpJ9fX1LS0spKSkcHBzuAGhlZWUlJSVubm4NDQ04ODj41uXrAF/1AGjwAHHrHXjnAGb7wdj2r8nnAGv03OnvT4vxfab99vz3kLj72errVI7zPITuaJvuVI3znb34ydngAFn36/Dsnbj3nbzrAFLxGHvoM3freKrvhLDzlcH9udT3daTrtMfpaJ/2jK3pO4jlHHrjSX/1VZb/7P3qMnDvyt74ZZfiUoTxAFsRg5SnAAAY/klEQVR4nO1ci1/a2Lbe2Ql372zeCCovBRVRYlUgAQIEBeFYB46VGTt3pvb2//8z7lo74ak90/ZMrU7z/XzAJoHkY73XSgjx4cOHDx8+fPjw4cOHDx8+fPjw4cOHDx8+fPjw4cOHDx8+fPjw4cOHDx8+fPjw4cOHDx8+fPjw4ePnAQXgP/mDT3/w8bwquOTNKKPEJ+8rIMnS9aDEEo0+/hIgddHNk4PzneNKJX1WOcrHfc39QlCdhLeUVWyFffK+EPENZR0b0R99UK8CoLJA1n5Ch8dg9CKRVGkHFs4ivuH7a1BSVJTcypJeAPaKvtn7AmwrSozQGVMYtOjkENjb/rGH9RpAyYmyuSxkVD45UJSsr7d/ibDyRn/MEoij4vuMv0RGST5l3c4UpfQDjuaVoVjRnyKvpCiVH3A0rwmURJ4UPEoxfkm4r1A/130SlCTT+lMhCSWnkGf40cp/AHCTzTwpVpSkQPTC7uNo3HvwjIf28kFp8A19UrpgEfKMpOSLRhKHW/ubKYqFl6c3/zmRyTytmrC4qygHixfDmWw6m0EJ9MlzQUmBEl3GxZ5roHPJikKOtkO8VUlidLOi7OfIT1auck9+USuW7lMyEMTKnU6DK5vrwWiuVMTaSmY19SAkUVQ2MsD3T8TeE5LiSZou2xb6djl7WsjnDw8P8+XT7F7Fq0ttrrDkCmWqqOwkfibVBdlKJUuAZCaXisejgIjuvuL2e0DaYpvlg+Wy3k42GX78Rrh9rgKsPvXCPxOUlGecnG2cF7fypWQiOGuXLUGPRGOJbUAiHnG7GtF4KpfJJJPJTCaXiMUjUr8jx0p8tucSa8stpH8QaHBDyceiq5btiaxi6UkklSwU048KzDNsz/eBneLJfDm/GZu7nX8WKNlUdnJLYvKkjMxPPZbZ2vssbRJlb1OwmSRx5C2eJ1+l5LGQxkIhxkiIU+2J193q5nkm6LZk3Vx1Sd3mlo8EU5snyywdF/fLh5vJ3Vwil0jkdhGgvnT2NVCq7yvKXj6TS5aP4RPiz3O+fys0rjPmtC/+ZIzyp1QHVhLgDSqFlHy2HM4tBE5PlLKVOW3p7OFuLBx89FbzveSf4IGyl/B2z21gKeHVgXHt7tKo1QyrO+LsySAMhCWJzKTLmfjj14Px3fzBQt6K+dyiELpE9OpcARJYVAreMvxg6yPyN5/a90aIkUCn0egPLvt1Q72qClDgUGhtIzy/YGbH1cVsPpmLRcPhcCQaT2RKWweVJeJKqeBsB/l//eOWmARTWsA4aL5egOevChpnF3bjvk0E5+2hBQ81TaPr5HlIlZd4Wkc6W0rM9PQ/+E1PzoC0MCS/K4goldeVfDDh9M0R44KHQpw5N6bRDwiHPd7Qzar01OHBE8SdbyVjHN6MfU24kVFSaysnr0xvKR/+ayQ0qmmMMibI9aBhNwUlDIRDg7+aVGLKFuk/CceS+dOjncqZUjney5YPMzGZTLDR21abwx5PhTHeg2Bsu1Q4PSkeFbP75YOzlMsVnU1WlR91jZaz6ZcYyXSu2JK0MHan1m4E03VNE7rGOCMglbrO+Pp+S8U5qoPyT2xbtacB9shhez4jnCtg/HewldyGbCMaj6VPD7PnJ9JIouWj2MZ8lNMtpyAvLobWQtaQaQtmQhq/nv5yFRAceXOqw95t766tkUc+xIMUCjCcQ3Vsjcdj0xrxR9EiqvvuPrqTzdRS9FKBHJfGkyfpk4zLWeRRsxefRRKb+UI+kyIvL4im7H0PxG3+HBRYkGq/0WQi8LZvTVujUbM3sf9dXT10GXQsxkD/HKjW2LAt27aM24BYIY+6xT3lwC0VuHvi39N9L97bLirZTDya2AEjuCZdkc3z9H4yl9jOHytb6ybyx0MMO0JbOVtgj99Z3Xtj0nQEQU3WenX1N4094UYQVAxrpjm23zlsaFpjtTFcbIgsRXECrZySGQUsBSFLlhqfAyX1VDGel/46tzy3AZocLSvHuzNZhSznVH9ZtUAacupNoa+saeCCe3Xj3+ArkFWmCXE/VgefIy9E6UXftEx10gfdVQcXYmEFKAmj1JUj3hRLtISFqyzO7+lkvzjLNeA3vpS3EXfsr6Ckd72wB/ctyBmOF0MeHBcQ9dC4Di2nAYyxX63abeC2/8B5iIYoOJQ/DavefOQzvF0YvMm0Zo3NsWXX3nJ4CoGi5yZ2ITI8jc/yiDzoXiSpKEculwdHnruls4L9EjfbaWUrOFuDjfWIgvNYL4M8plHwCQxjjA/XmhQ+ODD0sXxqGHfwWqB7VeUQxlBIOkCyup8/cEr4SLVNo9FpCw5RtnCqcLaURLIQA7rNb10nibNjpDGMBXoiKSsp5djchSwqDCBmWDLIrH3KG9kL/h5cfDUYJGbXo7u3b1t3rfftmU4CZ+2+bT4AB4LxwKAzApOnhYA8e8o+rzNUZ4Hhb7cjTWgQbYvqxzZyl0grSkHHoAb5yCg7aO1IatbcQN3dLuwVtwqHm5kc1lS899dJ/FwB77Fi4CgBId7/bnR8BeC4WfvW6nff3t3dtYbT/nTkdnlCBERo0gbxAc6YLq67/eE1pB51Sx2CNn6OPUo5hIMgyEAwCwwGDCQZlFSpJOY9tUPlXGoh2Up6a8BNPH98UN7M7GaShyfn+4nZsSVgz/h6kodqe/i9ifkCQBqg3da6ATrzAaz6K/gOoen8V9W0r9nMAoY4D9w0Bg9D1TIudCbJ+cxbQoYCqsrYdbfWQpmJQ0h8FJldZoDOMgoiBa948wOuDygving0JudeYNeMghuvfBB1V1MvQG3Bxnc+PXA2s8aUCQFSpzmiZZhWYKkuhYZRG04My/wIcoUVg88cPWyoUyGq018uYX+i43Rofp5fIXeJpRjPJe9g1QFQV8GRpXR0LSjB6QT0ti8gVKFsWh8KfRYmAG0apKQgZ826ZbfpUsYBrpMLdmuattnpjbBigKEfnWPuI8Fo8sC7/qdJk4sQye3IsE2GQNSVmvKsYTnPV/dBC+kiSpq9I0pYfF6rmr2Io0NK9MdHKmDvHup2QISWglmI6SBLaxq/16pM58u5LuWsB6r8MOw3Pqn9bqt6jYkbZmshBMM9GXMCzW7fqPV/ZTxEUuBkZZwh3xr4SYENWyLOPYjUY9307B0K6aLy5z4CA5qOvYAMDbT0ndlfb1dAVttujI0WXzFrusbCA8PuOEKw6rBvG3XD7F92h82Hajtw7TiBdvvhbji9tFTVUAcP4G1ZDNPY48SiIEqD6ccRGmpyZTU4l6txBSeEll5wZxOw2fEiLk8A8rqm5aytaiIwGds9yNVWImbRsmr2EIO3EBMscHcLBAJRRr0O/wBGvWEYsGRN7xwCopxAqTtL0iXuQD+V03UbhoXj9KMmBw1CPFJY1Vl4mAH2N19GTQooGZpmm6+mWxq/sscd4dklrPCFqNCb/bp97zBOObroEHhf6oxa3cuJbRvIntGw1Umn2wJXTHCY5xxz1FJwpfq2C2vBdY3DCFlehLB0WDjwpygHbjZC5t5mF940H3kpmRll7bo1ELpGF+Y7xG8apt1mrvXnIfQT1zfmL5OWQxay6DlLRigo7MVoNHq4aAc0QSRzyazbgF2Tp+AZKuL6IRASQ3mkSyN7YBxLbpCyVPyMH6aV482w3PB78fFVgMPoqkZLhOiSblUNC5IyqW7oBrTATb9u9S6IG/kuyCN69NFZaOHcIcqcUpHVk5XPwmGN4pOdoLKcf1wqqUpnkVkUrfU4SLLb8Xw5pVDIB0THVHvYuAA/C97X0Zhlqb9BUkZQrtp3XcvoDNsaMKfRtcp6MFneP8zg7EkkgtMoyfyJ21d7U054rbOlT5IDtnG67howGNaPZPa2GFzRdzCU85x0PLNVUQ5KcTcaeilKK00ad7o1oK/t2T0heubYcoTjXNz1Omrjalh1MNgLyZ9HCOby2TcrswHZwu4TV62gnB5jUvX41GVMtwW+JR+bE4v5HMTX4VimcKCcFQ8TOoltrxVbfjxkLarZt+tqf/p2VG232011bP/R7ViqNeg1AxphT3Rvl/aGv3o4nsjtZjK7uUTcHTl7LB5UphbH+tN+EguiqOw7p6VcKhaP57BSXz5KK2fZw904CjGy+1Js3QIYenBW7V1Zau3Tp1pNtcdWfzp8qEJyyvGHypxDOgLIMvBvyH2CDLHHwqC5q2sf44ZtCbJKwMJBoNvIHy2NU+1slbZnkqhL33u63AP6Oyn4dsiiBpahnOt2dVQN9ExTxdiFubUVr7CmMU2HDEPTmFR1DWsxstqyQgWTVhPIXtg1XTpHpOzIPf15PrtI68jckIWjsVQiIUvxcXczb1PwxzvzMsJix0Xpj7rl+mcGVgIYZPKcQ3IleMAc2zcc0lhJEJkdoICtONUFiB7FLiSeFPbHVxyILD3DqtCWsr2ZkCTBirlOhMwcAQ7jzpJisuRdorLiNKuHylcixVkJauZwFvHfvAX1/OLIiVNtXjDUNg3CtIFpWSyktR+ul3IzRq6ro2uI+ZpdQQm/rgZQwphTfdBWwuvAqAp8iPvWcpmeJhC5M2z9wP+Ym2SlEiha8SMvEgymcnh5hhvTgYpugH+JJyJz8ggpz6+DjicLhczspXAi7s20pT5jT78P4Pg411rvre69rQ45CL0mmqpZrwZuzYZRx+APdU5w52bS71596jr3ny4gr71sGDXIe0eXaqP++wXXNdn25u1b66o7qbeuB+oSpYxmzjY23mAEU9mBB+kEbJ3Zq2ydKkfRpFtJ1pN7lXK+opQwaKHyKtNUVA7wyogaZS11fu4Gx8HNirKZKsiKAXhgHAIsyeF6RWYpz0meqE5qQ86F87vR4xjkWWOr1/o0uUSvIUJY0xTasP6/F5zz96ZZGwr93r4E4exoA6PTMS3zVuooE4Hpp2mA87ZtqrWHpVqMCAZ13Y15Y7J5AzlaWtmFf1tKGkNmYGBHycMOOLKLVMJ/JZ9UNmRm7Co3chOTJGZkLwhLyRWgsqDguMxecF/ZwwfP2dYAskaGfQvUMfFHrQUKSbqWaV0OAoT1gD0tBDktq/Y/3aBx0yaW2dfEoMX/tC3zj8nQEfy9Zd7LpiRrGXYT7KS4UC1zKoILh9GuYtVPR0LcUwsXlRMswpMTt1iHvBZk7TPrXikOIpcunsRlrKegKutBWU3F7u2R4hb+IvK7ON0kYeyh7xyCL9l71rYG05nzu6k+CK5zp/aWcZDDxths3OF4xWBsDhhWlVq20WIhkNE7daxW0b9iP9uctJnGr+1x41egLCS6qgkL4JD/bZpWwDXjGkgtGb3n6HiAhw30uzpJpbEWqruRC3oFLJ5gixsoKkk5VGRiRiS7WeJldW9QZWNp2brwcpUUVqswA05j0oYEbz6f5EHaCkmseeWASl4MgTAdErWx2hQ616qqBQ/Auw7r9hCVUNMsy+7Ct6/xNgjXJMDA/+JUisOIYB9V9UI2itp1q9Z0wxddAHWXv7SwOBNz+6xufXMLYz0dvYK8qAp5KIaBiFhejg+g/m3PWJROIuF1aXHhxI2/C67Uyot5cZ4KxyMVJfx8WguRCfAAegqiJjjKVEu17BYHieEd27wEseOthtnFWjrlPdW0nBAQzDtjywYxcwRENWoLAkI2VbG5C+Edwf1mbQ/a7NSMoaDA/YE8a1didqQXkl4hQTwJVNJS1HA96RYEgLzi7K4ix26AiCL6JiivNUJl3SFu2QrUF9vC8mr8ZyQPArYuiJ5lXF5DcMtQC9Uuh2CNtwzLaAs9NLKticNwyEIWWgRudWeM6yOOM3wDczxhWoi9s80BAfYpfwuZXQCbkmAS7t7X7G6AgOGUhMjqUthzG6CjadnKwEX3DkrFqJQ73KI863WAcOnUrU152+XcwLAgdVSX34DMeFGzd541VAHN00Dzxpb54RrYEBDi9XE+gl7bVr3HNe7Ypg1qp3EKXnh8KQcfYU29JeBAWFO1jCqwdFFzi3+aZHjIsBbKAp2aOQxA+E3dG/1sylM8mTd/4FElLIXNdQxgEyMoeKdIAhKEoiSd76wYj0p75Nb3UNOPqWsut+SpzLodzwcN4jwSmDYsC6I8Rppw6iPmUE6mpjkBdSPSpmkolb+BQrdDQuOii26YM0c4sNstDj1C5DKFr4GxgCX9MdZL+cQGb8zcOv6Jq2N0Fq94dn7XpVH3hqfAFegk55IAjgWWNoK4AWjvHu6Tn/FD0XXLti0IYDqM22ABa2u9M/4diWNUtO/BYFHeNExrIIQzGZtdsIM6f1Cl29A5BH1TEECp3fUhWjVeNcbAMI7d3oJYOroeahsWWD6N6k4HvEwbZ0cpa3YdjvVVWJeEpOSZ7cPJygeox1lp4qJubLbr+gK9MiPBdRJe1zuGrXIg8dwVvBOXeSmL7jdwKL3F85GniYB9g8m/YBM0Z/RXEC7sBHEBAd1HFLJ2zTJ7AmI8kDYQRayGQvYG9g2NGkQ1dgsS3lDLGDdG4KEDfRMUGlh1wGM8aGJWxcIqXpnILDYtL/km0jO6M8fhSt4Ng9/I8CTp3rdrXgslNCJtI9YX9jw1lgZv2wsUi7JKE5d2gTxbGxyUrG+0OBZUHupGF6Tro1m/Q2ulDW3TqPLRpVatQyYBYcvk0hw3WqLaCQinYTUczILFFQR7zHl7S25M03wnnLsPf4yt2oW46wg4H5RX75MwzZJWTEa2SoTEs0dn6D8jJ7nIsYzNZhEMOk93HmpT6mjiwItJMkDkvnfJM7zfuewWBeU3oHs+V9dLz3YPDSre1SAMBtxBPIHN6r55JUcRxUfTGv8xubrm7Zo5Hr/v13A8ZfzHFcTF/MIAFcWBAg1MnzX4cAPxDdhMs6NOAkDn+GN/CkYSJ9FkeuuFePK+F0DfGfqFPaWEBh+yr23kCOULdRNJ1M/BJcgxCzm2fH4QQXlTssenQRnbgHRFQHtLctqKxmVwQt0epZI9KzzbPR9Cumh1ap2b+w+QZzGs193+qy1PWDQbDaPTFEIXtw1VnQwF6K/a+AA6ijnaFeayIK+3htEYtIWmO31btTtNyNBqhn1VXelt6dS9EZeHjOwLRUkYlLKSx8giA3SVCsdv8mHixr5xt7KCdvIALydF61h0u+bA9OGWcrAZnHmG43P3S5HieRJ/vt4GjnCy9sOo+ifDoUUCJLQZjl+DEWyP2hR0D55Wq0Aots8eLhjTIYwW7Wt5XQvlTrUawIQMIpnRCGISyOna1TZYzKVKFtiyzVlZE80WDswG8UE4kQoSOfNI44lcIu4V/Whw3r2NJ7zbjcYS7rQeRompXAotJY6oIn/RiFvFC5EUrj9fjR4vDQ0xrH+CAcMSATzTpeRh0CHHVfCqFSJbj7IaD7+QrqKCozUDI4kTLbKfJvAhTuOFGA4Z6HRR8IzIipGu6/Ni50oXe2bhF2vz0jVZFLLp0ivYwUPg8WF5G69x1Qh5Tuq+J5aUNiYHLnY2KpU3O8Wt5H9161oqicM5DwiZICqFX45pJX6rWMEQn522fEWQpxCJZfJg2WU7J18qHZZP5BXfx0n9m/mTOZ8I3Ez7PV1ord/egjEO9MZvna41YNWpdSs+N6L/ikBjya1jvO5xNxYOy5TeXQ4n8sDlzqNrU774fbFOc/e+yu8HotofcMiswzd3xvtue2D27tuWremf64++dHh9nFgJ9PSk5F6FJ71gJbzU6cpsYNjyaJjsi6CBlvZUh/EhhFCXjEF2KNjAGArw9k0eaEw5f5XkueToiXJaOdqMe01vN/KFWG7hFMBf7n3zBfDgnVq1KvgJEfwwBu8+/HTPm596XPRqd5x9VNeu1Ho1kBFFHi8pcyXO850Yu84GaIlHMWRb6W/7EEYc+5JjxbVl3EDqaEwcx+xw3v405aJZg9D9FZo8SQ42aLZiq8uYJZyv3YFFFudWb6X8RQB5a0+bn95xHu499GoBEZh8CLB3/6oKcWlfa864owWE9vrYwwwMDF15NUp1E4LF/XoW2yqPb4H014D40Z481NTB1aDNHn6pPtj3QcH+r8tY0AClbX7qd9vsFZJH9PzMiS6TJxOs3LpzoDTyTeRRR2s6evWuGeCQNVZbTYdrjqg6QuNNiP6c1ogL/trCZKxDQvJa1JfGKtwSk1clWh+VwvVvuVYW2++Y7OCVgYzj4BaVd37B9BBLQZg7/pfn8uygNLgnuVslCZLXY9lpfbQ92LyD9cWfF1hADz+6REffcwug7tPFCyh4jydxf1bEFG+YeL6Cj4M4JEtc2qLeqvy3jVdQ+PBQUNZvXISO48ArU+LTrb3DhBS2aKK0oySftT34wlGU7cDlFQiE99zEwlsObuezB3t7e8Wtzdi8+OSDSPKyS0+RmfiGcrx0ZdgqVZT8QwpvfwdAbfeWyKBkdlHjjzuk14Oo7KouENlXjlPk5U2tv0TIROI4PNPFSF7ZyBDyXE2sVw68PQpEeqU4Dpds7ysH2743/WLIZk8wVzjaOzooljMR3x18BeZFYu8SCJ+6r8a8QejDhw8fPnz48OHDhw8fPnz48OHDhw8fPnz8E4G3ytJ8fDWQtB/93b1uBHx8M4hquDfb9fGVAN7I//j4Zvw/NuVw/9CKGvkAAAAASUVORK5CYII=" style="width: 300px"></a>
            </div>
            <div class="search-container text-center mt-3">
                <form action="">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search.." >
                        <button type="submit"><i class="fa fa-search"></i></button>
                    </div>
                </form>
            </div>
            <form action="">
                <div class="mt-3" style="margin-left: 40px">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a href="/admin/hoadonview/banhang" class="nav-link"  target="loadpage">Bán hàng</a>
                        </li>
                        <hr>
                        <li class="nav-item">
                            <a href="/admin/sanphamview/sanpham" class="nav-link" target="loadpage">Sản phẩm</a>
                        </li>
                        <hr>
                        <li class="nav-item">
                            <a href="/admin/khachhangview/khachhang" class="nav-link" target="loadpage">Khách hàng</a>
                        </li>
                        <hr>
                        <li class="nav-item">
                            <a href="" class="nav-link">Khác</a>
                        </li>
                        <hr>
                        <li class="nav-item">
                            <a href="/user/logins" class="nav-link">Thoát</a>
                        </li>

                    </ul>
                </div>
        </div>
            </form>
    <div style="width: calc(100% - 300px);">
        <articel>
            <iframe name="loadpage" width="100%" height="100%" frameborder="0"></iframe>
        </articel>
    </div>
    </div>
</body>

</html>
