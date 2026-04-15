import matplotlib.pyplot as plt
import numpy as np
import sys


def inside_label(pct, allvals):
    absolute = int(pct/100.*np.sum(allvals))
    return "{:.1f}%\n({:d})".format(pct, absolute)


def plot_permutation(axe, permutations):
    labels = [str(x) for x in  permutations['permutation']]
    count = permutations["count"]
    
    wedges, texts, autotexts = axe.pie(count 
            #,labels=labels
            ,autopct=lambda pct: inside_label(pct, count)
            ,textprops=dict(color="w")
    )
    axe.axis('equal')
    ax.legend(wedges, labels,
          title="permutations",
          loc=(0.85,0.5)
          #loc="center left",
          #bbox_to_anchor=(0.5, 0., 0.5, 0.5)
   )

if __name__ == "__main__":
    # print(f"read data from {sys.argv[1]}")
    file_name= "./data.csv"
    per = np.genfromtxt(file_name
            ,dtype=None
            ,names=['permutation', 'count']
            ,delimiter=";"
            ,encoding="utf-8"
    )
    fig, ax = plt.subplots(nrows=1, ncols=1, sharey='col',figsize=(6,4))
    plot_permutation(ax, per)
    fig.savefig("img/permutation.pgf", format="pgf", bbox_inches = 'tight', pad_inches=0.)
    fig.savefig("img/permutation.png", format="png", bbox_inches = 'tight', pad_inches=0.)


